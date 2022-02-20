package cn.dancingsnow.create_sky.data;


import cn.dancingsnow.create_sky.CreateSky;
import cn.dancingsnow.create_sky.data.utility.FilesHelper;
import cn.dancingsnow.create_sky.data.utility.Lang;
import com.google.gson.JsonElement;

import java.util.function.Supplier;

public enum AllLangPartials {

    ADVANCEMENTS("Advancements"),
    MESSAGES("UI & Messages"),
    TOOLTIPS("Item Descriptions"),

    ;

    private String display;
    private Supplier<JsonElement> provider;

    private AllLangPartials(String display) {
        this.display = display;
        this.provider = this::fromResource;
    }

    private AllLangPartials(String display, Supplier<JsonElement> customProvider) {
        this.display = display;
        this.provider = customProvider;
    }

    public String getDisplay() {
        return display;
    }

    public JsonElement provide() {
        return provider.get();
    }

    private JsonElement fromResource() {
        String fileName = Lang.asId(name());
        String filepath = "assets/" + CreateSky.MOD_ID + "/lang/default/" + fileName + ".json";
        JsonElement element = FilesHelper.loadJsonResource(filepath);
        if (element == null)
            throw new IllegalStateException(String.format("Could not find default lang file: %s", filepath));
        return element;
    }
}
