package jp.co.fostone.springwebsys.service;


//


public abstract class BaseService {
	public void excute() {
		//log
		//パフォーマンス
		//権限
		//トランザクションBegin
		doBusiness();
		//トランザクションSubmit
	}

	public abstract void doBusiness();
}

class subService extends BaseService {
	public void doBusiness() {
		//ロジック
	}
}