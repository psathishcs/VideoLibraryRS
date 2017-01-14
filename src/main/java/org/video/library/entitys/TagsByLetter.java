package org.video.library.entitys;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

/**
 * 
 * @author Sathish
 *
 * Inverted index for tags by first letter in the tag
 *		CREATE TABLE tags_by_letter (
 *  		first_letter text,
 *  		tag text,
 *  		PRIMARY KEY (first_letter, tag)
 *		);
 *
 */

@Table(value="tags_by_letter")
public class TagsByLetter {
	@PrimaryKeyColumn(name="text", ordinal= 1, type=PrimaryKeyType.CLUSTERED)
	private String text;
	@PrimaryKeyColumn(name="tag", ordinal= 1, type=PrimaryKeyType.PARTITIONED)
	private String tag;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
}
