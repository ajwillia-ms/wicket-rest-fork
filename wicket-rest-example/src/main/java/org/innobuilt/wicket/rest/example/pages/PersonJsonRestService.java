package org.innobuilt.wicket.rest.example.pages;


import java.util.List;

import org.apache.log4j.Logger;
import org.apache.wicket.PageParameters;
import org.apache.wicket.model.Model;
import org.innobuilt.wicket.rest.JsonWebServicePage;
import org.innobuilt.wicket.rest.example.WicketRestApplication;
import org.innobuilt.wicket.rest.example.model.Person;
import org.innobuilt.wicket.rest.example.service.PersonService;

//TODO Post this back to http://blog.brunoborges.com.br/2008/11/restful-web-services-with-wicket.html
public class PersonJsonRestService extends JsonWebServicePage {
	
	private static final Logger LOGGER = Logger.getLogger(PersonJsonRestService.class);
	
	public static final String ID_KEY="id";
	public static final String EMAIL_KEY="email";
	public static final String USERNAME_KEY = "username";
	
	public PersonJsonRestService(PageParameters params) {
		super(params, Person.class);
		//I would prefer to only expose the fields I have annotated
		getBuilder().excludeFieldsWithoutExposeAnnotation();

	}

	@Override
	public void doGet(PageParameters params) {
		Person person = null;
		
		//return all if no params
		if (params.isEmpty()) {
			List<Person> persons = getPersonService().getAllPersons();
			setDefaultModel(new Model(persons.toArray(new Person[0])));
			return;
		} 
		Long personId = params.getAsLong(ID_KEY);
		String email = params.getString(EMAIL_KEY);
		String username = params.getString(USERNAME_KEY);
		
		if (personId != null) {
			person = getPersonService().getPerson(personId);
		}
		
		if (person == null && username != null) {
			person = getPersonService().getPerson(username);
		}
		
		if (person == null && email != null) {
			person = getPersonService().getPersonByEmail(email);
		}
		
		if (person != null) {
			setDefaultModel(new Model(person));
		}
		//TODO make docs available through framework by visiting /mounted-path/docs
	}

	@Override
	public void doPost(PageParameters params) {
		getPersonService().updatePerson((Person)getDefaultModelObject());
	}

	@Override
	public void doPut(PageParameters params) {
		Person person = (Person)getDefaultModelObject();
		//Ensure that the id is null
		person.setId(null);
		getPersonService().createPerson(person);
	}

	@Override
	public void doDelete(PageParameters params) {
		getPersonService().deletePerson(params.getAsLong("id"));
	}
	
	private PersonService getPersonService() {
		return WicketRestApplication.get().getPersonService();
	}
	
}
