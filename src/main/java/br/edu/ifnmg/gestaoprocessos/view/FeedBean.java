package br.edu.ifnmg.gestaoprocessos.view;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.jsoup.Jsoup;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.util.SerializableSupplier;

import com.google.common.io.ByteSource;

import br.edu.ifnmg.gestaoprocessos.data.post.PostDao;
import br.edu.ifnmg.gestaoprocessos.domain.file.FileEntity;
import br.edu.ifnmg.gestaoprocessos.domain.post.PostCategoryEnum;
import br.edu.ifnmg.gestaoprocessos.domain.post.PostEntity;

@Named
@ViewScoped
public class FeedBean implements Serializable {

	private static final long serialVersionUID = -1583188441961151735L;
	
	private PostEntity selectedPost;
	
	@Inject
	PostDao postDao;
	
	public List<PostEntity> getNews() {
		List<PostEntity> posts = postDao.findByCategory(PostCategoryEnum.NEWS);
		for (PostEntity postEntity : posts) {
			postEntity.setContent(formatRemoveHtmlTags(postEntity.getContent()));
		}
		return posts;
	}
	
	public List<PostEntity> getOrientations() {
		List<PostEntity> posts = postDao.findByCategory(PostCategoryEnum.ORIENTATION);
		for (PostEntity postEntity : posts) {
			postEntity.setContent(formatRemoveHtmlTags(postEntity.getContent()));
		}
		return posts;
	}
	
	public List<PostEntity> getEditals() {
		List<PostEntity> posts = postDao.findByCategory(PostCategoryEnum.EDITAL);
		for (PostEntity postEntity : posts) {
			postEntity.setContent(formatRemoveHtmlTags(postEntity.getContent()));
		}
		return posts;
	}
	
	public List<PostEntity> getExams() {
		List<PostEntity> posts = postDao.findByCategory(PostCategoryEnum.EXAMS);
		for (PostEntity postEntity : posts) {
			postEntity.setContent(formatRemoveHtmlTags(postEntity.getContent()));
		}
		return posts;
	}
	
	public String formatRemoveHtmlTags(String html) {
		return Jsoup.parse(html).text();
	}
	

//	public StreamedContent downloadFile(FileEntity file) {
//		StreamedContent downloadFile;
//		byte[] b = file.getContent().getBytes();
//    	downloadFile = DefaultStreamedContent.builder()
//                .name(file.getName())
//                .contentType(file.getMimetype())
//                .stream(() -> new ByteArrayInputStream(b))
//                .build();
//		return downloadFile;
//	}

	public PostEntity getSelectedPost() {
		return selectedPost;
	}

	public void setSelectedPost(PostEntity selectedPost) {
		this.selectedPost = selectedPost;
	}
	
	
}
