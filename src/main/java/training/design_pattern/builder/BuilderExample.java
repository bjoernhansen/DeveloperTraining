package training.design_pattern.builder;

import java.time.LocalDate;
import java.util.Optional;

public final class BuilderExample {
	private final int number;
	private final String text;
	private final LocalDate date; // optionaler Parameter
    private final String message; // optionaler Parameter

	private BuilderExample(int number, String text, LocalDate date, String message) {
        this.number = number;
        this.text = text;
        this.date = date;
        this.message = message;
	}

    public int getNumber() {
        return number;
    }

    public String getText() {
        return text;
    }

    public Optional<LocalDate> getDate() {
        return Optional.ofNullable(date);
    }

    public Optional<String> getMessage() {
        return Optional.ofNullable(message);
    }

	public static NumberBuilder builder() {
		return new Builder();
	}

	public interface NumberBuilder {
		TextBuilder number(int number);
	}

	public interface TextBuilder {
		OptionalParameterBuilder text(String text);
	}

	public interface OptionalParameterBuilder {
		OptionalParameterBuilder date(LocalDate date);
        OptionalParameterBuilder message(String message);
		BuilderExample build();
	}

	private static final class Builder implements NumberBuilder, TextBuilder, OptionalParameterBuilder {
        private int number;
        private String text;
        private LocalDate date; // optionaler Parameter
        private String message; // optionaler Parameter

		private Builder() {
		}

        @Override
        public OptionalParameterBuilder date(LocalDate date) {
            this.date = date;
            return this;
        }

        @Override
        public OptionalParameterBuilder message(String message) {
            this.message = message;
            return this;
        }

        @Override
        public TextBuilder number(int number) {
            this.number = number;
            return this;
        }

        @Override
        public OptionalParameterBuilder text(String text) {
            this.text = text;
            return this;
        }

        @Override
        public BuilderExample build() {
            return new BuilderExample(number, text, date, message);
        }
    }

    public static void main(String[] args) {
        BuilderExample example = builder()
                .number(42)
                .text("Hello, Builder!")
                .date(LocalDate.now())
                .message("Hello, World!")
                .build();

        System.out.println("Number: " + example.getNumber());
        System.out.println("Text: " + example.getText());
        System.out.println("Date: " + example.getDate().orElse(null));
        System.out.println("Message: " + example.getMessage().orElse(null));
    }
}
