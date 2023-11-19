package br.edu.ifnmg.gestaoprocessos.domain.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import br.edu.ifnmg.gestaoprocessos.domain.base.BaseEntity;

@Entity(name = "File")
@Table(name = "file")
public class FileEntity extends BaseEntity implements Serializable{
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	private FileType type;
	
	@Column(nullable = false, length = 255)
	private String path;
	
	@Column(nullable = false)
	private Long size;
	
	@Column(length = 255)
	private String mimetype;
	
	@Column(nullable = false, length = 255)
	private String name;
	
	@Column(nullable = false, length = 20)
	private String extension;

	public FileType getType() {
		return type;
	}

	public void setType(FileType type) {
		this.type = type;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public String getMimetype() {
		return mimetype;
	}

	public void setMimetype(String mimetype) {
		this.mimetype = mimetype;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}
	
	
}
