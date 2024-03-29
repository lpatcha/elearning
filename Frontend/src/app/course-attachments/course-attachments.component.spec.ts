import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CourseAttachmentsComponent } from './course-attachments.component';

describe('CourseAttachmentsComponent', () => {
  let component: CourseAttachmentsComponent;
  let fixture: ComponentFixture<CourseAttachmentsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CourseAttachmentsComponent]
    });
    fixture = TestBed.createComponent(CourseAttachmentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
