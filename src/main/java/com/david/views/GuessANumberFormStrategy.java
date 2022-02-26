package com.david.views;

import com.david.interfaces.GameFormStrategy;

public class GuessANumberFormStrategy implements GameFormStrategy {

    private static final String LS = System.lineSeparator();
    private static final String BR = "<br>";
    private StringBuilder builder;

    @Override
    public String createForm(String action) {
        builder = new StringBuilder();
        createFormOpenTag(action);
        cratetNumberInputTag();
        createSubmitInputTag();
        createFormCloseTag();
        return builder.toString();
    }

    private void createFormOpenTag(String action) {
        builder.append("<form method='post' action='");
        builder.append(action);
        builder.append("' >");
        builder.append(LS);
    }

    private void cratetNumberInputTag() {
        builder.append(
                "<input type='number' name='tip' value='Találgatok' required />");
        builder.append(LS);
    }

    private void createSubmitInputTag() {
        builder.append("<input type='submit'  value='Lássuk az eredményt' />");
        builder.append(LS);
    }

    private void createFormCloseTag() {
        builder.append("</form>");
    }
}
