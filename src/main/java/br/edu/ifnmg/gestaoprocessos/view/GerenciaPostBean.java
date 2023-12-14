package br.edu.ifnmg.gestaoprocessos.view;

import br.edu.ifnmg.gestaoprocessos.data.post.PostDao;
import br.edu.ifnmg.gestaoprocessos.domain.file.FileEntity;
import br.edu.ifnmg.gestaoprocessos.domain.file.FileType;
import br.edu.ifnmg.gestaoprocessos.domain.post.PostCategoryEnum;
import br.edu.ifnmg.gestaoprocessos.domain.post.PostEntity;
import br.edu.ifnmg.gestaoprocessos.domain.postsocial.PostSocialServiceLocal;
import br.edu.ifnmg.gestaoprocessos.utils.DataUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import org.jsoup.Jsoup;
import org.primefaces.model.file.UploadedFile;

@Named
@ViewScoped
public class GerenciaPostBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private PostEntity post = new PostEntity();
	private Integer activeTabIndex = 0;
	private List<PostEntity> listPost = new ArrayList<PostEntity>();
	private UploadedFile file;

	@Inject
	private PostDao postDao;
	@Inject
	private PostSocialServiceLocal postSocialService;

	@PostConstruct
	public void init() {
		listPost = postDao.listAll();
	}

	@Transactional(rollbackOn = Exception.class)
	public void registerPost() throws Exception {
		postDao.save(post);
		postSocialService.publish(post);

		if (listPost.contains(post) == false) {
			listPost.add(post);
		}
		post = new PostEntity();
	}

	@Transactional(rollbackOn = Exception.class)
	public void deletePost(PostEntity post) {
		postDao.delete(post);
		listPost.remove(post);
	}

	public void loadPost(PostEntity post) {
		this.post = new PostEntity();
		this.post = post;
		activeTabIndex = 0;
	}

	public void addFile() {
		if (file != null) {
			FileEntity fileEnt = new FileEntity();

			fileEnt.setContent(file.getContent().toString());
			fileEnt.setExtension(file.getContentType());
			fileEnt.setMimetype(file.getContentType());
			fileEnt.setName(file.getFileName());
			fileEnt.setSize(file.getSize());
			
			//fazer um switch para definir isso dps
			fileEnt.setType(FileType.OTHER);

			post.getAttachments().add(fileEnt);
		}
	}
	
	public void deleteFile(FileEntity file) {
		post.getAttachments().remove(file);
	}

	public String formatRemoveHtmlTags(String html) {
		return Jsoup.parse(html).text();
	}

	public String formatLastUpdateDataFromPost(PostEntity post) {
		return DataUtil.formatDateToBrazilianFormat(post.getUpdatedAt());
	}

	public PostEntity getPost() {
		return post;
	}

	public void setPost(PostEntity post) {
		this.post = post;
	}

	public PostCategoryEnum[] getCategorys() {
		return PostCategoryEnum.values();
	}

	public List<PostEntity> getListPost() {
		return listPost;
	}

	public void setListPost(List<PostEntity> listPost) {
		this.listPost = listPost;
	}

	public Integer getActiveTabIndex() {
		return activeTabIndex;
	}

	public void setActiveTabIndex(Integer activeTabIndex) {
		this.activeTabIndex = activeTabIndex;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

}
