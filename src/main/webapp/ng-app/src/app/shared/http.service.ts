/**
 * @author Fran lopez
 * @author Sergio Banegas
 */

import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

@Injectable()
export class HTTPService {

	constructor (private http:Http){}

	get(endpoint:string, headers?:Headers): Observable<any> {
		return this.http.get(endpoint, headers).map(this.extractData).catch(this.handleError);
	}

	post(endpoint:string, body:Object, headers?:Headers): Observable<any> {
		let options = new RequestOptions({headers: headers});
		return this.http.post(endpoint, body, options).map(this.extractData).catch(this.handleError);
	}

	put(endpoint:string, body:Object, headers?:Headers): Observable<any> {
		let options = new RequestOptions({headers: headers});
		return this.http.put(endpoint, body).map(this.extractData).catch(this.handleError);
	}

	delete(endpoint:string, headers?: Headers): Observable<any> {
		let options = new RequestOptions({headers: headers});
		return this.http.delete(endpoint).map(this.extractData).catch(this.handleError);
	}

	private extractData(res: Response) {
		return res.json();
	}
	private handleError (error: Response | any) {
		return Observable.throw(error.message || error.json());
	}
}