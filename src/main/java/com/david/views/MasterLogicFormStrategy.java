package com.david.views;

import com.david.interfaces.GameFormStrategy;
import com.david.utils.Color;

class MasterLogicFormStrategy implements GameFormStrategy {

    private static final String LS = System.lineSeparator();
    private static final String BR = "<br>";

    private StringBuilder builder;

    public MasterLogicFormStrategy() {
    }

    @Override
    public String createForm(String action) {
        builder = new StringBuilder();
        createFormOpenTag(action);
        createSelectTags();
        createSubmitInputTag();
        createFormCloseTag();
        return builder.toString();
    }

    private void createFormOpenTag(String action) {
        builder.append("<form method='post' action='");
        builder.append(action);
        builder.append("'>");
        builder.append(LS);
    }

    private void createSelectTags() {
        for (int i = 0; i < 4; i++) {
            builder.append("<select name='color");
            builder.append(i);
            builder.append("' >");
            builder.append(LS);
            createOptions(i);
            builder.append("</select>");
            builder.append(LS);
        }
        builder.append(BR);
        builder.append(LS);
    }

    private void createOptions(int i) {
        for (int j = 0; j < Color.length(); j++) {
            builder.append("<option value='");
            builder.append(j);
            builder.append("' ");
            if (i == j){
                builder.append("selected ");
            }
            builder.append(">");
            builder.append(Color.findColorByIndex(j));
            builder.append("</option>");
            builder.append(LS);
        }
    }

    private void createSubmitInputTag() {
        builder.append("<input type ='submit' value='OK' />");
    }

    private void createFormCloseTag() {
        builder.append("</form>");
    }
}
