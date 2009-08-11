package org.innobuilt.wicket.rest.example.pages;

import java.util.List;

import org.apache.wicket.PageParameters;
import org.apache.wicket.model.Model;
import org.innobuilt.wicket.rest.XmlWebServicePage;
import org.innobuilt.wicket.rest.example.WicketRestApplication;
import org.innobuilt.wicket.rest.example.model.Person;
import org.innobuilt.wicket.rest.example.service.PersonService;

public class PersonXmlRestService extends XmlWebServicePage {

	public PersonXmlRestService(PageParameters params) {
		super(params);
		//set up an xstream alias for the Person class so we don't see the package name
		getXStream().alias("person", Person.class);
	}

	@Override
	public void doDelete(PageParameters params) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doGet(PageParameters params) {
		if (params.isEmpty()) {
			List<Person> persons = getPersonService().getAllPersons();
			setDefaultModel(new Model(persons.toArray(new Person[0])));
		} //TODO allow for id, email, username and name queries
		//TODO make docs available through framework by visiting /mounted-path/docs
	}

	@Override
	public void doPost(PageParameters params) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doPut(PageParameters params) {
		// TODO Auto-generated method stub

	}

	private PersonService getPersonService() {
		return WicketRestApplication.get().getPersonService();
	}
}
