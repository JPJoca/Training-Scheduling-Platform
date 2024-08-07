package gui.view.typesOfViews;

import javax.swing.*;

public class Toolbar extends JToolBar {
    public Toolbar() {
        super(HORIZONTAL);
        setFloatable(false);

        add(LoginView.getInstance().getActionManager().getChangeInfoAction());
        add(LoginView.getInstance().getActionManager().getChangePasswordAction());
        add(LoginView.getInstance().getActionManager().getAddNotificationTypeAction());
        add(LoginView.getInstance().getActionManager().getListNotificationTypesAction());
        add(LoginView.getInstance().getActionManager().getListNotificationAction());
        add(LoginView.getInstance().getActionManager().getListClientAction());
    }
}
