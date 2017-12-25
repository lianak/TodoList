import {Injectable} from '@angular/core';
import {TodoListItem} from './todolistitem';
import {Observable} from 'rxjs/Observable';
import {Http, Response, Headers} from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class TodoListService {

  private completedItemsUrl = 'http://localhost:8081/todolistitem/completed';
  private unCompletedItemsUrl = 'http://localhost:8081/todolistitem/uncompleted';
  private updateUrl = 'http://localhost:8081/todolistitem/';

  constructor(private http: Http) {
  }

  getCompleted(): Observable<TodoListItem[]> {
    return this.http.get(this.completedItemsUrl)
      .map((response: Response) => <TodoListItem[]> response.json());
  }

  getUnCompleted(): Observable<TodoListItem[]> {
    return this.http.get(this.unCompletedItemsUrl)
      .map((response: Response) => <TodoListItem[]> response.json());
  }

  updateItem(listItem: TodoListItem) {
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    listItem.completed = true;
    this.http
      .put(this.updateUrl + listItem.id,
        JSON.stringify(listItem),
        {headers: headers})
      .subscribe(
        (response: Response) => console.log(response),
        (error: Error) => console.log(error),
        () => console.log('completed')
      );
  }

  createItem(listItem: TodoListItem, unCompleted, addToUnComleted): void {
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    let createdItem: TodoListItem = null;
    this.http
      .post(this.updateUrl,
        JSON.stringify(listItem),
        {headers: headers})
      .subscribe(
        (response: Response) => {
          const result = JSON.parse(response.text());
          createdItem = new TodoListItem(result.id, result.title, result.completed);
          addToUnComleted.call(null, unCompleted, createdItem);
        },
        (error: Error) => console.log(error),
        () => console.log('completed'));
  }

}
