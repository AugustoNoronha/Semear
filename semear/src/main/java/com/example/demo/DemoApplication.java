package com.example.demo;

import com.example.demo.Bowvine.Bowvine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.rowset.serial.SerialBlob;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@GetMapping
	public List<Bowvine> hello() throws SQLException {
		byte[] bytes = "A byte array".getBytes();
		Blob blob = new SerialBlob(bytes);
		return List.of(

				new Bowvine(
						1L,
						"Garanhão",
						new Date(2003-12-31),
						"Garanhaão2",
						"não sei oq é isso",
						"M",
						"Marrom",
						1L,
						"Precisa receber uma classe ?",
						"O+",
						blob

				)
		);
	}
}
