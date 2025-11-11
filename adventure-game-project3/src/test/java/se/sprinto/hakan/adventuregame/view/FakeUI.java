package se.sprinto.hakan.adventuregame.view;

public class FakeUI implements UI {

    private String input;

    @Override
    public void showMessage(String message) {
    }

    public void setInput(String input) {
        this.input = input;
    }


    @Override
    public String getInput(String prompt) {
        return input;
    }


}
