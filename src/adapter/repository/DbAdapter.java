package adapter.repository;

import java.util.List;

public interface DbAdapter<T> {

	List<T> buscar();
}
