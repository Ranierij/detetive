package senacDetetive;

public class senacDetetive {
    public static void main(String[] args) {
        System.out.println("Bem-vindo ao sistema de interrogatório do Senac Detetives.");
        System.out.println("Responda 'sim' ou 'não' para as seguintes perguntas:");

        String[] perguntas = {"Telefonou para a vítima?", "Esteve no local do crime?", "Mora perto da vítima?",
                "Devia para a vítima?", "Já trabalhou com a vítima?"};

        String[] respostas = new String[perguntas.length];

        for (int i = 0; i < perguntas.length; i++) {
            System.out.print(perguntas[i]);
            respostas[i] = readLine().toLowerCase();
        }

        String classificacao = classificarParticipacao(respostas);
        System.out.println("Baseado nas suas respostas, você foi classificado como: " + classificacao);
    }

    private static String readLine() {
        byte[] buffer = new byte[1024];
        int bytesRead;
        StringBuilder sb = new StringBuilder();
        try {
            bytesRead = System.in.read(buffer);
            for (int i = 0; i < bytesRead; i++) {
                char ch = (char) buffer[i];
                if (ch == '\r' || ch == '\n') {
                    break;
                }
                sb.append(ch);
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    private static String classificarParticipacao(String[] respostas) {
        int totalSim = 0;
        for (String resposta : respostas) {
            if (resposta.equals("sim")) {
                totalSim++;
            }
        }

        if (totalSim == 1) {
            return "Inocente";
        }else if(totalSim == 2) {
            return "Suspeito";
        } else if (totalSim >= 3 && totalSim <= 4) {
            return "Cúmplice";
        } else if (totalSim == 5) {
            return "Assassino";
        } else {
            return "";
        }
    }
}
