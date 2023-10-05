import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListMachineryPageComponent } from './list-machinery-page.component';

describe('ListMachineryPageComponent', () => {
  let component: ListMachineryPageComponent;
  let fixture: ComponentFixture<ListMachineryPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ListMachineryPageComponent]
    });
    fixture = TestBed.createComponent(ListMachineryPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
