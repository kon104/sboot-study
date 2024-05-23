package jp.mydns.kon104.study.sboot.testutil;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import jp.mydns.kon104.study.sboot.bean.Accounts;
import jp.mydns.kon104.study.sboot.repository.AccountsRepository;

public class TestUtilMockBaseBuilder {

	public static AccountsRepository buildAccountsRepository() {
		AccountsRepository mockBase = new AccountsRepository() {

			@Override
			public void flush() {
				// TODO 自動生成されたメソッド・スタブ
				
			}

			@Override
			public <S extends Accounts> S saveAndFlush(S entity) {
				// TODO 自動生成されたメソッド・スタブ
				return null;
			}

			@Override
			public <S extends Accounts> List<S> saveAllAndFlush(Iterable<S> entities) {
				// TODO 自動生成されたメソッド・スタブ
				return null;
			}

			@Override
			public void deleteAllInBatch(Iterable<Accounts> entities) {
				// TODO 自動生成されたメソッド・スタブ
				
			}

			@Override
			public void deleteAllByIdInBatch(Iterable<Integer> ids) {
				// TODO 自動生成されたメソッド・スタブ
				
			}

			@Override
			public void deleteAllInBatch() {
				// TODO 自動生成されたメソッド・スタブ
				
			}

			@Override
			public Accounts getOne(Integer id) {
				// TODO 自動生成されたメソッド・スタブ
				return null;
			}

			@Override
			public Accounts getById(Integer id) {
				// TODO 自動生成されたメソッド・スタブ
				return null;
			}

			@Override
			public Accounts getReferenceById(Integer id) {
				// TODO 自動生成されたメソッド・スタブ
				return null;
			}

			@Override
			public <S extends Accounts> List<S> findAll(Example<S> example) {
				// TODO 自動生成されたメソッド・スタブ
				return null;
			}

			@Override
			public <S extends Accounts> List<S> findAll(Example<S> example, Sort sort) {
				// TODO 自動生成されたメソッド・スタブ
				return null;
			}

			@Override
			public <S extends Accounts> List<S> saveAll(Iterable<S> entities) {
				// TODO 自動生成されたメソッド・スタブ
				return null;
			}

			@Override
			public List<Accounts> findAll() {
				// TODO 自動生成されたメソッド・スタブ
				return null;
			}

			@Override
			public List<Accounts> findAllById(Iterable<Integer> ids) {
				// TODO 自動生成されたメソッド・スタブ
				return null;
			}

			@Override
			public <S extends Accounts> S save(S entity) {
				// TODO 自動生成されたメソッド・スタブ
				return null;
			}

			@Override
			public Optional<Accounts> findById(Integer id) {
				// TODO 自動生成されたメソッド・スタブ
				return Optional.empty();
			}

			@Override
			public boolean existsById(Integer id) {
				// TODO 自動生成されたメソッド・スタブ
				return false;
			}

			@Override
			public long count() {
				// TODO 自動生成されたメソッド・スタブ
				return 0;
			}

			@Override
			public void deleteById(Integer id) {
				// TODO 自動生成されたメソッド・スタブ
				
			}

			@Override
			public void delete(Accounts entity) {
				// TODO 自動生成されたメソッド・スタブ
				
			}

			@Override
			public void deleteAllById(Iterable<? extends Integer> ids) {
				// TODO 自動生成されたメソッド・スタブ
				
			}

			@Override
			public void deleteAll(Iterable<? extends Accounts> entities) {
				// TODO 自動生成されたメソッド・スタブ
				
			}

			@Override
			public void deleteAll() {
				// TODO 自動生成されたメソッド・スタブ
				
			}

			@Override
			public List<Accounts> findAll(Sort sort) {
				// TODO 自動生成されたメソッド・スタブ
				return null;
			}

			@Override
			public Page<Accounts> findAll(Pageable pageable) {
				// TODO 自動生成されたメソッド・スタブ
				return null;
			}

			@Override
			public <S extends Accounts> Optional<S> findOne(Example<S> example) {
				// TODO 自動生成されたメソッド・スタブ
				return Optional.empty();
			}

			@Override
			public <S extends Accounts> Page<S> findAll(Example<S> example, Pageable pageable) {
				// TODO 自動生成されたメソッド・スタブ
				return null;
			}

			@Override
			public <S extends Accounts> long count(Example<S> example) {
				// TODO 自動生成されたメソッド・スタブ
				return 0;
			}

			@Override
			public <S extends Accounts> boolean exists(Example<S> example) {
				// TODO 自動生成されたメソッド・スタブ
				return false;
			}

			@Override
			public <S extends Accounts, R> R findBy(Example<S> example,
					Function<FetchableFluentQuery<S>, R> queryFunction) {
				// TODO 自動生成されたメソッド・スタブ
				return null;
			}

			@Override
			public Accounts findByUidAndPassword(int uid, String password) {
				// TODO 自動生成されたメソッド・スタブ
				return null;
			}
		};
		return mockBase;
	}
}
