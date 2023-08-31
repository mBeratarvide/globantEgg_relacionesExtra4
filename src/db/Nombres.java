package db;

public class Nombres {

    private static String[] nombres = {
            "Croqueta",
            "Oreganato",
            "Calabresa",
            "Bodoque",
            "Aceituna",
            "Anacleto",
            "Rigoberto",
            "Aerolitos",
            "Anastacio",
            "Filiberta"
    };

    private static String[] apellidos = {
            "Copenage",
            "Canada",
            "Ucrania",
            "Rusia",
            "Bosnia",
            "Ecuador",
            "Paraguay",
            "Bolivia",
            "Uruguay",
            "Chile"
    };

    public static String[] getNombres() {
        return nombres;
    }

    public static String[] getApellidos() {
        return apellidos;
    }

}
