import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //Casp de uso: Añadir un cliente

        Cliente c1 = new Cliente("39462414A", "Diego", "Ribas");
        db.addCliente(c1);
        ArrayList<Cliente> listaClientes = db.getListaClientes();
        System.out.println(listaClientes);


    }
}