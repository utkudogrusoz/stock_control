package com.utkudogrusoz.stockcontrol.response;

public class FrontlineMessage {
    private String title;
    private String description;
    private String buttonPositive;

    public FrontlineMessage() {
    }

    public FrontlineMessage(String title, String description, String buttonPositive) {
        this.title = title;
        this.description = description;
        this.buttonPositive = buttonPositive;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getButtonPositive() {
        return buttonPositive;
    }

    public void setButtonPositive(String buttonPositive) {
        this.buttonPositive = buttonPositive;
    }
    public static FrontlineMessageBuilder builder(){
        return new FrontlineMessageBuilder();
    }
    public static class FrontlineMessageBuilder{
        private String title;
        private String description;
        private String buttonPositive;

        public FrontlineMessageBuilder() {
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public String getButtonPositive() {
            return buttonPositive;
        }
        public FrontlineMessageBuilder title(String title){
            this.title=title;
            return this;
        }
        public FrontlineMessageBuilder description(String description){
            this.description=description;
            return this;
        }


        public FrontlineMessage build() {
            return new FrontlineMessage(title,description,buttonPositive);
        }
    }
}
