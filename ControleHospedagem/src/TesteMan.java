import br.com.poo.ConexaoBanco.ConexaoMySQL;

public class TesteMan {

	public static void main(String[] args) {
		ConexaoMySQL con1 = new ConexaoMySQL();
		con1.getConexaoMySQL();
		System.out.println(ConexaoMySQL.statusConection());
		con1.FecharConexao();

	}

}
