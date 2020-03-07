package web.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@RequestScoped

public class produtoBean {

	private Produto produto;
	private static List<Produto> lista;
	private DataModel<Produto> produtos;
	
	
	//inicializar com a lista quando o objeto for criado
	@PostConstruct
	public void init() {
		lista = new ArrayList<Produto>();
		lista.add(new Produto("Iphone",9000.0));
		lista.add(new Produto("Xiaomi",2000.0));
	}
	
	public Produto getProduto() {
		return produto;
	}

		/// actions
	public String adicionaForm() {
		produto = new Produto();
		return "produto_form";
		//a navegação ocorre retornando a string da página se tiver dentro de pasta tem a barra
	}


	public String excluirProduto() {
		//a lista é recuperada no getRowData
		Produto p = (Produto) (produtos.getRowData());
		lista.remove(p);
		return "home";
	}
	


	///gets and sets
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public DataModel<Produto> getProdutos() {
		produtos = new ListDataModel<Produto>(lista);
		return produtos;
	}

	public void setProdutos(DataModel<Produto> produtos) {
		this.produtos = produtos;
	}
	
	
}
