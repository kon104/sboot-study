package jp.mydns.kon104.study.sboot.service;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import jp.mydns.kon104.study.sboot.bean.Accounts;
import jp.mydns.kon104.study.sboot.repository.AccountsRepository;

@SpringBootTest
public class AccountsServiceTest {

	@Mock
	private AccountsRepository mockRepository = new AccountsRepository() {

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

	@InjectMocks
	private AccountsServiceImpl target;
	
	private static List<Accounts> accounts = new ArrayList<>();

	@BeforeAll
	public static void advancePreparation() {
		System.out.printf("%s#%s\n",
				new Object(){}.getClass().getEnclosingClass().getName(),
				new Object(){}.getClass().getEnclosingMethod().getName());
		accounts.add(new Accounts(1, "佐藤", "1234567"));
		accounts.add(new Accounts(2, "鈴木", "abcdefg"));
		accounts.add(new Accounts(3, "高橋", "hijklmn"));
		accounts.add(new Accounts(4, "田中", "opqrstu"));
		accounts.add(new Accounts(5, "伊藤", "vwxyzAB"));
	}

	@BeforeEach
	public void eachInitialization() {
		System.out.printf("%s#%s\n",
				new Object(){}.getClass().getEnclosingClass().getName(),
				new Object(){}.getClass().getEnclosingMethod().getName());
		when(mockRepository.findByUidAndPassword(accounts.get(0).getUid(), accounts.get(0).getPassword())).thenReturn(accounts.get(0));
		when(mockRepository.findByUidAndPassword(accounts.get(1).getUid(), accounts.get(1).getPassword())).thenReturn(accounts.get(1));
		when(mockRepository.findByUidAndPassword(accounts.get(2).getUid(), accounts.get(2).getPassword())).thenReturn(accounts.get(2));
		when(mockRepository.findByUidAndPassword(accounts.get(3).getUid(), accounts.get(3).getPassword())).thenReturn(accounts.get(3));
		when(mockRepository.findByUidAndPassword(accounts.get(4).getUid(), accounts.get(4).getPassword())).thenReturn(accounts.get(4));
	}
	
	@Test
	public void searchAccountTest() {
		System.out.printf("%s#%s\n",
				new Object(){}.getClass().getEnclosingClass().getName(),
				new Object(){}.getClass().getEnclosingMethod().getName());

		for (Iterator<Accounts> itr = accounts.iterator(); itr.hasNext();) {
			Accounts user = itr.next();
			Accounts result = target.searchAccount(user.getUid(), user.getPassword());
			assertThat(result.getUid()).isEqualTo(user.getUid());
			assertThat(result.getName()).isEqualTo(user.getName());
			assertThat(result.getPassword()).isEqualTo(user.getPassword());	
		}
	}

}
