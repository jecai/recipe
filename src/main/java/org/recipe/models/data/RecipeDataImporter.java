package org.recipe.models.data;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.recipe.models.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

public class RecipeDataImporter {

    private static final String DATA_FILE = "recipe_data.csv";
    private static boolean isDataLoaded = false;

    /**
     * Read in data from a CSV file and store it in a list
     */
    static void loadData(RecipeData recipeData) {

        // Only load data once
        if (isDataLoaded) {
            return;
        }

        try {

            // Open the CSV file and set up pull out column header info and records
            Resource resource = new ClassPathResource(DATA_FILE);
            InputStream is = resource.getInputStream();
            Reader reader = new InputStreamReader(is);
            CSVParser parser = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(reader);
            List<CSVRecord> records = parser.getRecords();
            Integer numberOfColumns = records.get(0).size();
            String[] headers = parser.getHeaderMap().keySet().toArray(new String[numberOfColumns]);

            // Put the records into a more friendly format
            for (CSVRecord record : records) {

                String ingredientStr = record.get("ingredient");
                String servingStr = record.get("serving");
                String calorieStr = record.get("calorie");
                String imageUrlStr = record.get("image url");

                Ingredient ingredient = recipeData.getIngredients().findByValue(ingredientStr);
                if (ingredient == null) {
                    ingredient = new Ingredient(ingredientStr);
                    recipeData.getIngredients().add(ingredient);
                }

                Serving serving = recipeData.getServings().findByValue(servingStr);
                if (serving == null) {
                    serving = new Serving(servingStr);
                    recipeData.getServings().add(serving);
                }

                Calorie calorie = recipeData.getCalores().findByValue(calorieStr);
                if (calorie == null) {
                    calorie = new Calorie(calorieStr);
                    recipeData.getCalores().add(calorie);
                }

                ImageUrl imageUrl = recipeData.getImageUrl().findByValue(imageUrlStr);
                if (imageUrl == null) {
                    imageUrl = new ImageUrl(imageUrlStr);
                    recipeData.getImageUrl().add(imageUrl);
                }

                Recipe newRecipe = new Recipe(record.get("name"), ingredient, serving, calorie, imageUrl);

                recipeData.add(newRecipe);
            }

            // flag the data as loaded, so we don't do it twice
            isDataLoaded = true;

        } catch (IOException e) {
            System.out.println("Failed to load job data");
            e.printStackTrace();
        }
    }

}
