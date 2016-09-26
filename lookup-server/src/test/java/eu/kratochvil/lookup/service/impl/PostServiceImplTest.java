package eu.kratochvil.lookup.service.impl;

import eu.kratochvil.lookup.Application;
import eu.kratochvil.lookup.entities.Post;
import eu.kratochvil.lookup.entities.Tag;
import eu.kratochvil.lookup.service.PostService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertNotNull;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class PostServiceImplTest {

	@Autowired
	private PostService postService;

	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;

	@Before
	public void before() {
		elasticsearchTemplate.deleteIndex(Post.class);
		elasticsearchTemplate.createIndex(Post.class);
		elasticsearchTemplate.putMapping(Post.class);
		elasticsearchTemplate.refresh(Post.class);
	}


	@Test
	public void testCreate() throws Exception {
		List<Tag> tags = Arrays.asList(new Tag("1", "Tag1"), new Tag("2", "Tag2"));

		Post post = new Post();
		post.setId("123");
		post.setTitle("Test");
		post.setTags(tags);

		postService.save(post);
		Post postDb = postService.findOne("123");
		assertNotNull(postDb);
	}

	@Test
	public void testFindOne() throws Exception {

	}

	public void testFindAll() throws Exception {

	}


}