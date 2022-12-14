package net.satisfyu.meadow.util;

import com.google.gson.stream.JsonWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AdvancementRecipeGenerator {

    public static final String FOLDER = "C:/Users/Admin/Documents/GitHub/meadow/src/main/resources/data/meadow/advancements/recipes/";

    public static void main(String[] args) {
        /*
        Mach die item condition und das Rezept in die Liste und trenne sie mit einem "/" (so wie die Beispiele in der Liste). So kannst du viele Advancements auf einmal erstellen.
        FOLDER gibt das Verzeichnis an, in dem die Advancements landen mit / am Ende! Wichtig!
        Drücke dann auf das play Symbol links von der main method und die Advancements sollten generiert werden.
         */
        List<String> putRecipesHere = List.of("cobbled_limestone/chiseled_limestone_bricks");




        for(String s : putRecipesHere){
            List<String> list1 = Arrays.stream(s.split("/")).toList();
            write(list1.get(0), list1.get(1));
        }
    }


    public static void write(String condition, String recipe) {
        String fullRecipe = "meadow:" + recipe;
        String fullCondition = "meadow:" + condition;

        if(condition.contains(":")){
            fullCondition = condition;
            condition = Arrays.stream(condition.split(":")).toList().get(1);
        }

        if(recipe.contains(":")){
            fullRecipe = condition;
            recipe = Arrays.stream(recipe.split(":")).toList().get(1);
        }



        // Writing
        try (FileWriter fileWriter = new FileWriter(FOLDER + recipe + ".json"); JsonWriter jsonWriter = new JsonWriter(fileWriter)) {
            jsonWriter.setIndent("  ");
            jsonWriter.beginObject()
                    .name("parent").value("minecraft:recipes/root")
                    .name("rewards").beginObject().name("recipes").beginArray().value(fullRecipe).endArray().endObject()
                    .name("criteria").beginObject().name("has_" + condition).beginObject().name("trigger").value("minecraft:inventory_changed").name("conditions").beginObject().name("items").beginArray().beginObject().name("items").beginArray().value(fullCondition).endArray().endObject().endArray().endObject().endObject().name("has_the_recipe").beginObject().name("trigger").value("minecraft:recipe_unlocked").name("conditions").beginObject().name("recipe").value(fullRecipe).endObject().endObject().endObject()
                    .name("requirements").beginArray().beginArray().value("has_" + condition).value("has_the_recipe").endArray().endArray()

                    .endObject();
        } catch (IOException e) {
            System.out.printf("[Meadow] Couldn't write recipe to " + FOLDER + recipe);
            e.printStackTrace();
        }
    }
}
