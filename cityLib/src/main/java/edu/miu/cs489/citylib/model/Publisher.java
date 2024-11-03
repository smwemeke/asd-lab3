package edu.miu.cs489.citylib.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Setter
@Getter
@Table(name = "publishers")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer publisherId;
    @Column(name = "publisher_name")
    private String publisherName;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "address_id")
    private Address primaryAddress;

    @OneToMany(mappedBy = "publisher")
    private List<Book> bookList;  // Publisher - || ------<- Book

    public Publisher(String publisherName, Address primaryAddress) {
        this.publisherName = publisherName;
        this.primaryAddress = primaryAddress;
    }
    @Override
    public String toString(){
        return "Publisher{" +
                "publisherName='" + publisherName + '\'' +
                ", primaryAddress=" + primaryAddress +
                '}';

   }

}
