package entidades;

public class Usuario {
	    private String nome;
	    private String cpf;
	    private String email;
	    private String endereco;
	    
	    // Construtor
	    public Usuario(String nome, String cpf, String email, String endereco) {
	        this.nome = nome;
	        this.cpf = cpf;
	        this.email = email;
	        this.endereco = endereco;
	    }  
	    
	    // Getters e Setters
		public String getCpf() {
			return cpf;
		}

		public void setCpf(String cpf) {
			this.cpf = cpf;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

	    public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getEndereco() {
			return endereco;
		}

		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}

		@Override
	    public String toString() {
	        return getNome() + "," + getCpf() + "," + email + "," + endereco;
	    }
		
	    public static Usuario fromString(String linha) {
	        String[] parts = linha.split(",");
	        return new Usuario(parts[0], parts[1], parts[2], parts[3]);
	    }
	}