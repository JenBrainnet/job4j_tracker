package ru.job4j.enumeration;

public enum Status implements Code {

    ACCEPTED(1, "Принят") {
        private String message = "Автомобиль принят на СТО";

        @Override
        public String getMessage() {
            return message;
        }
    },
    IN_WORK(2, "В работе") {
        private String message = "Автомобиль в работе";

        @Override
        public String getMessage() {
            return message;
        }
    },
    WAITING(3, "Ожидает клиента") {
        private String message = "Автомобиль ожидает запчасти";

        @Override
        public String getMessage() {
            return message;
        }
    },
    FINISHED(4, "Завершен") {
        private String message = "Все работы завершены";

        @Override
        public String getMessage() {
            return message;
        }
    };

    private final int code;
    private final String text;

    Status(int code, String text) {
        this.code = code;
        this.text = text;
    }

    public String info() {
        return text;
    }

    public abstract String getMessage();

    public static void main(String[] args) {
        Status toyota = Status.FINISHED;
        Status volvo = Status.WAITING;
        System.out.println("Статус Toyta: " + toyota.info());
        System.out.println("Статус Volvo: " + volvo.info());
    }

    @Override
    public int code() {
        return code;
    }

}
