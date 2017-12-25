import {Component, OnInit} from '@angular/core';
import {TodoListItem} from '../todolistitem';
import {TodoListService} from '../todo-list.service';

@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.css']
})
export class TodoListComponent implements OnInit {

  completed: TodoListItem[];
  unCompleted: TodoListItem[];
  showCompleted: boolean;
  toBeAddedItem: TodoListItem;
  arrowDown: boolean;
  arrowValue: String;

  constructor(private listService: TodoListService) {
    this.showCompleted = true;
    this.arrowDown = true;
    this.arrowValue = 'keyboard_arrow_down';
    this.toBeAddedItem = new TodoListItem(null, '', false);
  }

  ngOnInit() {
    this.getCompleted();
    this.getUnCompleted();
  }

  getCompleted(): void {
    this.listService.getCompleted().subscribe(completed => this.completed = completed);
  }

  getUnCompleted(): void {
    this.listService.getUnCompleted().subscribe(uncompleted => this.unCompleted = uncompleted);
  }

  onCheck(event, listItem: TodoListItem) {
    if (event.target.checked) {
      listItem.completed = true;
      this.listService.updateItem(listItem);
      const index: number = this.unCompleted.indexOf(listItem, 0);
      if (index > -1) {
        this.completed.push(this.unCompleted[index]);
        this.unCompleted.splice(index, 1);
      }

    }
  }

  onShowCompletedIconClick(event) {
    this.showCompleted = !this.showCompleted;
    if (this.showCompleted) {
      this.arrowValue = 'keyboard_arrow_down';
    } else {
      this.arrowValue = 'keyboard_arrow_right';
    }
  }
}
