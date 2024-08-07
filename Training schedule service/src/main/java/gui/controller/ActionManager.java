package gui.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActionManager {
    private ChangeInfoAction changeInfoAction;
    private ChangePasswordAction changePasswordAction;
    private AddNotificationTypeAction addNotificationTypeAction;
    private ListNotificationTypesAction listNotificationTypesAction;
    private ListNotificationAction listNotificationAction;
    private ListClientAction listClientAction;

    public ActionManager(){
        changeInfoAction = new ChangeInfoAction();
        changePasswordAction = new ChangePasswordAction();
        addNotificationTypeAction = new AddNotificationTypeAction();
        listNotificationTypesAction = new ListNotificationTypesAction();
        listNotificationAction = new ListNotificationAction();
        listClientAction = new ListClientAction();
    }
}
