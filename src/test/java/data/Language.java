package data;

public enum Language {
    RU("Первый Санкт-Петербургский государственный медицинский университет им. акад. И.П. Павлова"),
    EN("Pavlov University");

    public final String description;

    Language(String description) {
        this.description = description;
    }
}
