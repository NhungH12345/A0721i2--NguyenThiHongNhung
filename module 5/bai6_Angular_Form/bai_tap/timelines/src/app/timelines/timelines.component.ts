import { Component, OnInit } from '@angular/core';
import {DateUtilService} from '../service/date-util.service';
@Component({
  selector: 'app-timelines',
  templateUrl: './timelines.component.html',
  styleUrls: ['./timelines.component.css']
})
export class TimelinesComponent implements OnInit {
  // @ts-ignore
  output: '';

  constructor(private dateUtilService: DateUtilService) { }

  ngOnInit(): void {
  }

  onChange(value: string) {
    // @ts-ignore
    this.output = this.dateUtilService.getDiffToNow(value);
  }


}
