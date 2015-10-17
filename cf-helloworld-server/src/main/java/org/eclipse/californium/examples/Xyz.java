package org.eclipse.californium.examples;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutorService;

import org.eclipse.californium.core.network.Endpoint;
import org.eclipse.californium.core.network.Exchange;
import org.eclipse.californium.core.observe.ObserveRelation;
import org.eclipse.californium.core.server.resources.Resource;
import org.eclipse.californium.core.server.resources.ResourceAttributes;
import org.eclipse.californium.core.server.resources.ResourceObserver;
import static org.eclipse.californium.core.coap.CoAP.ResponseCode.*;

@SuppressWarnings("unused")
public class Xyz implements Resource {
	public Xyz()
	{
		super();
		getAttributes().setTitle("Xyz");
	}

	@Override
	public void handleRequest(Exchange exchange) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getPath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPath(String path) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getURI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCachable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isObservable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ResourceAttributes getAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Resource child) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean remove(Resource child) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Resource> getChildren() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resource getChild(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resource getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setParent(Resource parent) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addObserver(ResourceObserver observer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeObserver(ResourceObserver observer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addObserveRelation(ObserveRelation relation) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeObserveRelation(ObserveRelation relation) {
		// TODO Auto-generated method stub

	}

	@Override
	public ExecutorService getExecutor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Endpoint> getEndpoints() {
		// TODO Auto-generated method stub
		return null;
	}

}
