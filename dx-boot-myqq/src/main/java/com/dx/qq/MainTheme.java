package com.dx.qq;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.DefaultMutableThemeStyle;
import com.googlecode.lanterna.graphics.DelegatingThemeDefinition;
import com.googlecode.lanterna.graphics.ThemeDefinition;
import com.googlecode.lanterna.graphics.ThemeStyle;

public class MainTheme extends DelegatingThemeDefinition {

    public MainTheme(ThemeDefinition definition) {
        super(definition);

    }


    @Override
    public ThemeStyle getActive() {
        DefaultMutableThemeStyle mutableThemeStyle = new DefaultMutableThemeStyle(super.getActive());
        return mutableThemeStyle.setBackground(TextColor.Factory.fromString("CYAN"));
    }


}
