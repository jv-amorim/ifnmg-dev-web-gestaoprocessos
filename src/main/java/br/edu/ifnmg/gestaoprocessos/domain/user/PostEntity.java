package br.edu.ifnmg.gestaoprocessos.domain.user;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.edu.ifnmg.gestaoprocessos.domain.applicant.SelectionProcessEntity;
import br.edu.ifnmg.gestaoprocessos.domain.base.BaseEntity;

@Entity(name = "Post")
@Table(name = "post")
public class PostEntity extends BaseEntity implements Serializable{
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	private PostCategoryEnum category;
	
	@Column(nullable = false, length = 255)
	private String title;
	
	@Column(nullable = false, length = 1000)
	private String content;
	
	@ManyToOne(cascade =  CascadeType.ALL)
	@JoinColumn(name = "selectionProcessid", nullable = false)
	private SelectionProcessEntity process;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private ArrayList<FileEntity> attachments;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private ArrayList<PostHistoryEntity> history;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private ArrayList<PostSocialEntity> socialPosts;

	public PostCategoryEnum getCategory() {
		return category;
	}

	public void setCategory(PostCategoryEnum category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public SelectionProcessEntity getProcess() {
		return process;
	}

	public void setProcess(SelectionProcessEntity process) {
		this.process = process;
	}

	public ArrayList<FileEntity> getAttachments() {
		return attachments;
	}

	public void setAttachments(ArrayList<FileEntity> attachments) {
		this.attachments = attachments;
	}

	public ArrayList<PostHistoryEntity> getHistory() {
		return history;
	}

	public void setHistory(ArrayList<PostHistoryEntity> history) {
		this.history = history;
	}

	public ArrayList<PostSocialEntity> getSocialPosts() {
		return socialPosts;
	}

	public void setSocialPosts(ArrayList<PostSocialEntity> socialPosts) {
		this.socialPosts = socialPosts;
	}
	
	
}
