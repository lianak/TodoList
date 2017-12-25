import {Component, Input, OnInit} from '@angular/core';
import {TodoListItem} from '../todolistitem';
import {FormControl} from '@angular/forms';
import {TodoListService} from '../todo-list.service';

@Component({
  selector: 'app-add-item',
  templateUrl: './add-item.component.html',
  styleUrls: ['./add-item.component.css']
})
export class AddItemComponent implements OnInit {

  @Input() unCompleted: TodoListItem[];
  @Input() toBeAddedItem: TodoListItem;

  showAddForm: boolean;
  addItemControl: FormControl;


  constructor(private listService: TodoListService) {
    this.addItemControl = new FormControl();
    this.showAddForm = false;
    this.toBeAddedItem = new TodoListItem(null, '', false);
  }

  ngOnInit() {
  }

  onSubmit() {
    if ((typeof this.addItemControl.value) === 'string'
      && this.addItemControl.value !== '') {
      this.toBeAddedItem.title = '';
      this.toBeAddedItem.completed = false;
      const newItem: TodoListItem = new TodoListItem(null,
        this.addItemControl.value,
        false);
      this.listService.createItem(newItem,
        this.unCompleted,
        (unCompletedList, createdItem) => unCompletedList.push(createdItem));
      this.addItemControl.reset();
    }
  }

  onAddIconClick(event) {
    this.showAddForm = !this.showAddForm;
  }
}
