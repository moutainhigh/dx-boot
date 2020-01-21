package com.dx.qq.window;

import com.dx.qq.QQUser;
import com.dx.qq.sdk.Friend_List;
import com.googlecode.lanterna.gui2.*;

import java.util.Arrays;

public class FriendListWindow extends BasicWindow {

    private Panel contentPanel;

    private ChatWindow chatwindow;

    private Button button;


    public FriendListWindow(String title, ChatWindow _chatwindow) {
        super(title);
        this.chatwindow = _chatwindow;
        this.setHints(Arrays.asList(Window.Hint.FIXED_SIZE, Window.Hint.NO_POST_RENDERING));
        this.contentPanel = new Panel(new LinearLayout(Direction.VERTICAL)); // can hold multiple sub-components that will be added to a wind
        this.button = new Button("<---  --->");
        this.contentPanel.addComponent(this.button);
        this.setComponent(this.contentPanel);

    }


    public void setfriendlist(final QQUser user) {

        if (user.friend_list != null) {
            for (Friend_List.Friend members : user.friend_list.members) {
                FriendListWindow.this.contentPanel.addComponent(new friendbutton().setchatwindow(this.chatwindow).setname(members.friend_name).setuin(String.valueOf(members.friend_uin)).setaction().settext());
            }

        } else {

        }

    }


}


class friendbutton extends Button {
    public friendbutton() {
        super("");
    }


    private String groupuin;
    private String groupname;
    private ChatWindow chatwindow;

    public Component settext() {
        this.setLabel(" " + this.groupname + "   暂无");
        return this;
    }

    public friendbutton setuin(String _groupuin) {
        this.groupuin = _groupuin;
        return this;
    }

    public friendbutton setname(String _name) {
        this.groupname = _name;
        return this;

    }

    public friendbutton setchatwindow(ChatWindow _chatwindow) {
        this.chatwindow = _chatwindow;
        return this;

    }

    public friendbutton setaction() {

        this.addListener(new Listener() {
            @Override
            public void onTriggered(Button button) {
                chatwindow.onupdate(Long.parseLong(groupuin), 1, groupname);
            }
        });
        return this;
    }


}
