import br.com.poo.Util.Repository.RepositoryException;
import br.com.poo.controleHospedagem.entity.Cliente;
import br.com.poo.controleHospedagem.entity.Repository.ClienteRepository;

public class TesteMan {

	public static void main(String[] args) throws RepositoryException {
		Cliente cliente = new Cliente("POPETE","ENDERECO", "BA", "000000000", "0000000", "POPETE@gmail.com");	
		( new ClienteRepository() ).inserir(cliente);		
	}

}
