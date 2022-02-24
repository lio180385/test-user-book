package com.books.user;

import java.util.ArrayList;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.books.user.model.Book;

import com.books.user.request.RequestBook;
import com.books.user.request.RequestUserAndBook;

 
@SpringBootTest
public class BookTest {
	RestTemplate restTemplate = new RestTemplate();

	@Test
	public void testCreatetestBook() {
		RequestUserAndBook requestUserAndBook = new RequestUserAndBook();
		requestUserAndBook.setUserId(1);
		RequestBook buku1 = new RequestBook();
		buku1.setBook_tittle("Tanya Malam");
		buku1.setBook_content("<!DOCTYPE html>\r\n"
				+ "<html lang=\"\"en\"\" xmlns:th=\"\"http://www.thymeleaf.org\"\">\r\n" + "<head>\r\n"
				+ "    <title>Laporan Bank Umum (LBU)</title>\r\n" + "</head>\r\n" + "<body>\r\n"
				+ " <table style=\"\"width: 130%\"\">\r\n" + "  <tr>\r\n"
				+ "   <td>Jenis laporan bulanan bank umum konvensional dibagi menjadi 4 Jenis:</td>\r\n" + "  </tr>\r\n"
				+ "  <tr>\r\n" + "   <td>\r\n"
				+ "   <li>Laporan Gabungan<br>Kantor pusat bank yang memiliki kantor cabang wajib menyampaikan laporan secara gabungan dari&nbsp;kantor cabangnya baik kantor cabang yang melakukan kegiatan operasional di Indonesia maupun di&nbsp;luar Indonesia. Bagi kantor cabang bank asing laporan gabungan dimaksud adalah gabungan dari kantor&nbsp;cabang pembantunya yang melakukan kegiatan operasional di Indonesia. Laporan ini terdiri dari 8 Form, yaitu:<p></p>\r\n"
				+ "    <ol>\r\n" + "     <li>Neraca dan Rekening Administratif Gabungan (Form-01)</li>\r\n"
				+ "     <li>Laporan Laba/Rugi Gabungan (Form-02)</li>\r\n"
				+ "     <li>Daftar Rincian Aset Antarkantor pada Kantor yang Melakukan Kegiatan Operasional di Indonesia&nbsp;(Gabungan) (Form-03)</li>\r\n"
				+ "     <li>Daftar Rincian Aset Antarkantor pada Kantor yang Melakukan Kegiatan Operasional di Luar Indonesia&nbsp;(Gabungan) (Form-04)</li>\r\n"
				+ "     <li>Daftar Rincian Rupa-Rupa Aset Gabungan (Form-05)</li>\r\n"
				+ "     <li>Daftar Rincian Kewajiban Antarkantor pada Kantor yang Melakukan Kegiatan Operasional di Indonesia (Gabungan) (Form-06)</li>\r\n"
				+ "     <li>Daftar Rincian kewajibab Antarkantor pada Kantor yang Melakukan Kegiatan Operasional di Luar&nbsp;Indonesia (Gabungan) (Form-07)</li>\r\n"
				+ "     <li>Daftar Rincian Rupa-Rupa Kewajiban Gabungan (Form-08)</li>\r\n" + "    </ol>\r\n"
				+ "    </li>\r\n" + "   </td>\r\n" + "  </tr>\r\n" + "  <tr>\r\n" + "   <td>\r\n"
				+ "    <li>Laporan per Kantor Bank Pelapor<br>\r\n"
				+ "    Setiap kantor bank yang melakukan kegiatan operasional diwajibkan membuat dan menyampaikan&nbsp;LBU adalah&nbsp;Kantor pusat dan kantor-kantor cabang yang berkedudukan di Indonesia dan&nbsp;Kantor-kantor operasional bank di luar Indonesia. Memiliki 52 form pelaporan yang dibagi menjadi 3 jenis rincian, yaitu:<p></p>\r\n"
				+ "    <ul>\r\n" + "    <li>Neraca dan Daftar Rincian Pos Neraca (form-01 – form41)</li>\r\n"
				+ "    <li>Daftar Rincian Pos Rekening Administratif dan Informasi Lainnya (form-42 – form-48)</li>\r\n"
				+ "    <li>Lain-lain (Form-49-Form-52)</li>\r\n" + "    </ul>\r\n" + "    </li>\r\n" + "   </td>\r\n"
				+ "  </tr>\r\n" + "  <tr>\r\n" + "   <td>\r\n" + "    <li>Laporan Anak perusahaan<br>\r\n"
				+ "    Kantor pusat&nbsp;bank yang memiliki anak perusahaan, wajib menyampaikan laporan perusahaan anak dan laporan&nbsp;secara konsolidasi dari bank sebagai perusahaan induk dengan perusahaan anaknya. memiliki 10 Form:<p></p>\r\n"
				+ "    <ol>\r\n" + "    <li>Neraca dan Rekening Administratif (Form-01)</li>\r\n"
				+ "    <li>Laporan Laba/Rugi (Form-02)</li>\r\n"
				+ "    <li>Daftar Rincian Penempatan Pada Bank (Form-03)</li>\r\n"
				+ "    <li>Daftar Rincian Tagihan Spot dan Derivatif (Form-04)</li>\r\n"
				+ "    <li>Daftar Rincian Surat Berharga (Form-05)</li>\r\n"
				+ "    <li>Daftar Rincian Surat Berharga yang Dijual dengan Janji Dibeli Kembali (Repo) (Form-06)</li>\r\n"
				+ "    <li>Daftar Rincian Tagihan Atas Surat Berharga yang Dibeli dengan Janji Dijual kembali (Reverse Repo)&nbsp;(Form-07)</li>\r\n"
				+ "    <li>Daftar Rincian Tagihan Akseptasi (Form-08)</li>\r\n"
				+ "    <li>Daftar Rincian Kredit yang Diberikan (Form-09)</li>\r\n"
				+ "    <li>Daftar Rincian Penyertaan (Form-10)</li>\r\n" + "    </ol>\r\n" + "    </li>\r\n"
				+ "   </td>\r\n" + "  </tr>  \r\n" + "  <tr>  \r\n" + "   <td><li>Laporan Konsolidasi</li></td>\r\n"
				+ "  </tr>\r\n" + " </table>\r\n" + "</body>\r\n" + "</html>");
		RequestBook buku2 = new RequestBook();
		buku2.setBook_tittle("Tanya sisa");
		buku2.setBook_content("disaat sisa ini sendidir");
		List<RequestBook> listbBooks = new ArrayList<>();
		listbBooks.add(buku1);
		listbBooks.add(buku2);
		requestUserAndBook.setBooks(listbBooks);

		ResponseEntity<RequestUserAndBook> postResponse = restTemplate
				.postForEntity("http://localhost:8089/userandbook", requestUserAndBook, RequestUserAndBook.class);
		Assert.assertNotNull(postResponse);
		Assert.assertNotNull(postResponse.getBody());
	}

	@Test
	public void testGetAllBooks() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange("http://localhost:8089/books", HttpMethod.GET, entity,
				String.class);

		Assert.assertNotNull(response.getBody());
	}

	@Test
	public void testGetBookById() {
		Book book = restTemplate.getForObject("http://localhost:8089/book/34", Book.class);
		System.out.println(book.getBook_tittle() + " " + book.getBook_content());
		Assert.assertNotNull(book);
	}

	@Test
	public void testUpdatePost() {
		long id = 34;
		Book book = restTemplate.getForObject("http://localhost:8089/book/" + id, Book.class);
		book.setBook_tittle("Matahari Terbit");
		book.setBook_content("jauh dari sana Aku Melihat");
		restTemplate.put("http://localhost:8089/books/" + id, book);

		Book updatedBook = restTemplate.getForObject("http://localhost:8089/book/" + id, Book.class);
		Assert.assertNotNull(updatedBook);

	}

	@Test
	public void testDeletePost() {
		int id = 35;
		Book book = restTemplate.getForObject("http://localhost:8089/book/" + id, Book.class);
		Assert.assertNotNull(book);

		restTemplate.delete("http://localhost:8089/book/" + id);

		try {
			book = restTemplate.getForObject("http://localhost:8089/book/" + id, Book.class);
		} catch (final HttpClientErrorException e) {
			Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}

}
