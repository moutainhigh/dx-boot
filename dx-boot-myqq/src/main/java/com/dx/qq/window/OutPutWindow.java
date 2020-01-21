package com.dx.qq.window;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class OutPutWindow extends BasicWindow {

    private TextBox textbox;

    private Panel contentPanel;


    public OutPutWindow(String title) {
        super(title);
        log.info("记录下title: " + title);
        this.setHints(Arrays.asList(Window.Hint.FIXED_SIZE, Window.Hint.NO_POST_RENDERING));

        this.contentPanel = new Panel(new GridLayout(2)); // can hold multiple sub-components that will be added to a window
        this.textbox = new TextBox();

        this.contentPanel.addComponent(this.textbox);
        com.googlecode.lanterna.gui2.TextBox.TextBoxRenderer tbr = this.textbox.getRenderer();
        com.googlecode.lanterna.gui2.TextBox.DefaultTextBoxRenderer dtbr = (TextBox.DefaultTextBoxRenderer) tbr;
        dtbr.setHideScrollBars(true);


        this.setComponent(contentPanel);


    }

    public void setlogsize(TerminalSize size) {
        this.textbox.setPreferredSize(size);


    }

    public void print(String text) {
        this.textbox.addLine(text);


        this.handleInput(new KeyStroke(KeyType.ArrowDown));
    }


}

