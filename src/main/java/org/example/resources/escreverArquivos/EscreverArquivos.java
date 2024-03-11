package org.example.resources.escreverArquivos;

import java.util.List;

public interface EscreverArquivos {


    void escreverDados(String nomeArquivo, List<?> lista);
    /*private void escreverDadosDiretores(String nomeArquivo, List<Diretor> diretores) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Diretor diretor : diretores) {
                writer.write(String.format("%-8d | %-25s | %-10s | %-2c", diretor.getId(),
                        diretor.getNome(), diretor.getDataNascimento(), diretor.getSexo()));
                for (Filme filmes : diretor.getFilmes()) {
                    writer.write(String.format(" | %-25s - %-15s - %-4d - %-4d - %-100s",
                            filmes.getNome(), filmes.getGenero(), filmes.getDataLancamento(),
                            filmes.getDuracao(), filmes.getDescricao()));
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
    
}
