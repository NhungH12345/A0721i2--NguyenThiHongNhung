import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReactiveStudentComponent } from './reactive-student.component';

describe('ReactiveStudentComponent', () => {
  let component: ReactiveStudentComponent;
  let fixture: ComponentFixture<ReactiveStudentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReactiveStudentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReactiveStudentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
