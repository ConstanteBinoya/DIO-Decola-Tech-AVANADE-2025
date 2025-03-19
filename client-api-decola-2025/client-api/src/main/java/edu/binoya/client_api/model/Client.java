package edu.binoya.client_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "clients_table") // Nome da tabela alterado para evitar conflito com palavras reservadas
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O primeiro nome não pode estar em branco")
    @Size(min = 2, max = 50, message = "O primeiro nome deve ter entre 2 e 50 caracteres")
    private String firstName;

    @NotBlank(message = "O sobrenome não pode estar em branco")
    @Size(min = 2, max = 50, message = "O sobrenome deve ter entre 2 e 50 caracteres")
    private String lastName;

    @Min(value = 18, message = "A idade mínima permitida é 18 anos")
    @Max(value = 100, message = "A idade máxima permitida é 100 anos")
    private Integer age; // Alterado para Integer para evitar problemas com valores padrão

    // Construtores, Getters e Setters
    public Client() {}

    public Client(String firstName, String lastName, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }
}
