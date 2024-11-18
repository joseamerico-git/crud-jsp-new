package dao;

import model.api.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao {
    Connection connection = ConnectionFactory.getConnection();

    public void salvar(Cliente cliente) {
        try {
            String query = "INSERT INTO cliente (codigo, nome)VALUES (?,?)";

            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, cliente.getNome());


            stmt.execute();
            stmt.close();
            connection.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void alterar(Cliente cliente) {
        try {
            PreparedStatement stmt;
            stmt = connection.prepareStatement("UPDATE cliente SET nome=? WHERE codigo =?");
            stmt.setLong(1, cliente.getCodigo());
            stmt.setString(2, cliente.getNome());

            stmt.execute();
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Cliente> getClientes() {
        Cliente cliente = new Cliente();
        List<Cliente> clientes = new ArrayList<>();
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("SELECT *FROM cliente order by nome");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                cliente = new Cliente();
                cliente.setCodigo(rs.getLong("codigo"));
                cliente.setNome(rs.getString("nome"));


                clientes.add(cliente);

            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return clientes;
    }

    public boolean existeCliente(int codigo) {
        Cliente cliente;
        boolean existe = false;
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("SELECT * FROM cliente WHERE codigo = ? ;");
            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                cliente = new Cliente();
                cliente.setCodigo(rs.getLong("codigo"));
                cliente.setNome(rs.getString("nome"));

                existe = true;
            }

            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Cliente não encontrado!");
        }
        return existe;

    }

    public Cliente getClienteCodigo(int codigo) {
        Cliente cliente = new Cliente();
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("SELECT * FROM cliente WHERE codigo = ? ;");
            stmt.setLong(1, codigo);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                cliente = new Cliente();
                cliente.setCodigo(rs.getLong("codigo"));
                cliente.setNome(rs.getString("nome"));


            }
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Cliente não encontrado!");
        }
        return cliente;
    }

    public Cliente getClienteNome(String nome) {
        Cliente usuario = new Cliente();
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("SELECT * FROM cliente WHERE nome = ? ;");
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                usuario = new Cliente();
                usuario.setCodigo(rs.getLong("codigo"));
                usuario.setNome(rs.getString("nome"));

            }
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }


    public List<Cliente> getUsuariosNome(String nome) {
        Cliente cliente = new Cliente();
        List<Cliente> clientes = new ArrayList<>();
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("SELECT * FROM cliente WHERE nome like ? LIMIT 100");
            stmt.setString(1, "%" + nome + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                cliente = new Cliente();
                cliente.setCodigo(rs.getLong("codigo"));
                cliente.setNome(rs.getString("nome"));


                clientes.add(cliente);

            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return clientes;

    }

    public Cliente getIndex(int index) {
        List<Cliente> clientes = new ArrayList<>();
        clientes = new ClienteDao().getClientes();
        Cliente cliente = new Cliente();
        cliente = clientes.get(index);
        return cliente;
    }

    public Cliente getIndex(int index, String nome) {
        List<Cliente> clientes = new ArrayList<>();
        clientes = new ClienteDao().getUsuariosNome(nome);
        Cliente c = new Cliente();
        c = clientes.get(index);
        return c;
    }

    public void excluir(Long codigo) {
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("DELETE FROM cliente WHERE codigo = ?;");
            stmt.setLong(1, codigo);
            stmt.execute();
            stmt.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}