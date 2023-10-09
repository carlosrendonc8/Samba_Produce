import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditMachineryPageComponent } from './edit-machinery-page.component';

describe('EditMachineryPageComponent', () => {
  let component: EditMachineryPageComponent;
  let fixture: ComponentFixture<EditMachineryPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EditMachineryPageComponent]
    });
    fixture = TestBed.createComponent(EditMachineryPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
