package com.pluralsight;

public class NameFormatter {



        // Private constructor to prevent instantiation
        private NameFormatter() {}

        // Format with just first and last name
        public static String format(String firstName, String lastName) {
            return String.format("%s, %s", lastName, firstName);
        }

        // Format with prefix, first, middle, last, and suffix
        public static String format(String prefix, String firstName, String middleName, String lastName, String suffix) {
            StringBuilder reformat = new StringBuilder();

            reformat.append(lastName).append(", ");

            if (prefix != null && !prefix.isEmpty()) {
                reformat.append(prefix).append(" ");
            }

            reformat.append(firstName);

            if (middleName != null && !middleName.isEmpty()) {
                reformat.append(" ").append(middleName);
            }

            if (suffix != null && !suffix.isEmpty()) {
                reformat.append(", ").append(suffix);
            }

            return reformat.toString();
        }

        // Format from fullName string like "Dr. Mel B Johnson, PhD"
        public static String format(String fullName) {

            String [] parts = fullName.split(",");
            String mainPart = parts[0];
            String suffix = parts.length > 1 ? parts[1]: "";

            String [] nameParts = mainPart.split(" ");

            String prefix = "", firstName = "", middleName = "", lastName = "";

            switch (nameParts.length){
                case 4:
                    prefix = nameParts[0];
                    firstName = nameParts[1];
                    middleName = nameParts[2];
                    lastName = nameParts[3];
                    break;
                case 3:
                    firstName = nameParts[0];
                    middleName = nameParts[1];
                    lastName = nameParts[2];

                case 2:
                    firstName = nameParts[0];
                    lastName = nameParts[1];
                    break;
            }





//            String suffix = "";
//            String namePart = fullName;
//
//            // Split suffix if exists
//            if (fullName.contains(",")) {
//                String[] parts = fullName.split(",", 2);
//                namePart = parts[0].trim();
//                suffix = parts[1].trim();
//            }
//
//
//            String[] tokens = namePart.split("\\s+");
//            String prefix = "", firstName = "", middleName = "", lastName = "";
//
//            if (tokens.length == 4) {
//                prefix = tokens[0];
//                firstName = tokens[1];
//                middleName = tokens[2];
//                lastName = tokens[3];
//            } else if (tokens.length == 3) {
//                firstName = tokens[0];
//                middleName = tokens[1];
//                lastName = tokens[2];
//            } else if (tokens.length == 2) {
//                firstName = tokens[0];
//                lastName = tokens[1];
            }

            return format(prefix, firstName, middleName, lastName, suffix);
        }
}


