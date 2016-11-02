package com.peopleincrowd.magestorm.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import com.peopleincrowd.magestorm.guis.CreateModuleForm;

/**
 * Created by vanthiepnguyen on 31/10/2016.
 */
public class CreateModule extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        Project project = e.getProject();
        CreateModuleForm.main(project.getBasePath());
    }
}
