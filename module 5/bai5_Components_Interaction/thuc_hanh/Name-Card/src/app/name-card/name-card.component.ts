import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-name-card',
  templateUrl: './name-card.component.html',
  styleUrls: ['./name-card.component.css']
})
export class NameCardComponent implements OnInit {
  //cha truyền các thông tin sang con
  @Input() cardName: string | undefined;
  @Input() email: string | undefined;
  @Input() phone: string | undefined;

  constructor() { }

  ngOnInit(): void {
  }

}
